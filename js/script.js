const analyzeButton = document.querySelector('#analyze-song');
const apiKeyInput = document.querySelector('#gemini-api-key');
const lyricsElement = document.querySelector('#song-lyrics, #song-lyrics-input');
const meaningElement = document.querySelector('#song-meaning');
const statusElement = document.querySelector('#analysis-status');

if (!analyzeButton || !apiKeyInput || !lyricsElement || !meaningElement || !statusElement) {
  throw new Error('Faltan controles de análisis en esta página.');
}

async function analizarSignificado(letra, apiKey) {
  if (window.location.protocol === 'file:') {
    throw new Error('Abre la página mediante Live Server o un servidor local, no directamente como archivo.');
  }

  const response = await fetch(
    `https://generativelanguage.googleapis.com/v1beta/models/gemini-3.6-flash:generateContent?key=${encodeURIComponent(apiKey)}`,
    {
      method: 'POST',
      headers: { 'Content-Type': 'application/json' },
      body: JSON.stringify({
        contents: [{
          parts: [{
            text: `Analiza brevemente esta letra: explica su significado general, sus metáforas principales y el tema emocional. Responde en español y usa párrafos cortos.\n\n${letra}`,
          }],
        }],
      }),
    },
  );

  const data = await response.json();

  if (!response.ok) {
    const apiMessage = data.error?.message || 'Comprueba la API key y la cuota disponible.';
    throw new Error(`Gemini respondió con un error: ${apiMessage}`);
  }

  return data.candidates?.[0]?.content?.parts?.[0]?.text || 'Gemini no devolvió un análisis.';
}

analyzeButton.addEventListener('click', async () => {
  const apiKey = apiKeyInput.value.trim();
  const lyrics = lyricsElement instanceof HTMLTextAreaElement
    ? lyricsElement.value.trim()
    : lyricsElement.textContent.trim();

  if (!apiKey) {
    statusElement.textContent = 'Introduce tu API key de Gemini.';
    apiKeyInput.focus();
    return;
  }

  if (!lyrics) {
    statusElement.textContent = 'Pega primero la letra de la canción en la sección Lyrics.';
    lyricsElement.focus();
    return;
  }

  analyzeButton.disabled = true;
  statusElement.textContent = 'Analizando...';

  try {
    const analysis = await analizarSignificado(lyrics, apiKey);
    meaningElement.textContent = analysis;
    statusElement.textContent = 'Análisis completado.';
  } catch (error) {
    statusElement.textContent = error instanceof TypeError
      ? `No se pudo conectar con Gemini: ${error.message}. Revisa la consola del navegador y que la URL empiece por http://.`
      : error.message;
  } finally {
    analyzeButton.disabled = false;
  }
});