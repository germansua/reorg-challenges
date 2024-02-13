import React, { useState } from 'react';

const UrlShortenerForm = () => {
  const [longUrl, setLongUrl] = useState('');
  const [shortUrl, setShortUrl] = useState('');

  const handleSubmit = async (e) => {
    e.preventDefault();

    const response = await fetch('http://localhost:8080/api/shorten', {
      method: 'POST',
      headers: {
        'Content-Type': 'application/json',
      },
      body: JSON.stringify({ longUrl }),
    });

    const result = await response.json();
    setShortUrl(result);
  };

  return (
    <div>
      <form onSubmit={handleSubmit}>
        <label>
          URL larga:
          <input type="text" value={longUrl} onChange={(e) => setLongUrl(e.target.value)} />
        </label>
        <button type="submit">Acortar URL</button>
      </form>

      {shortUrl && (
        <div>
          <p>URL corta generada:</p>
          <a href={shortUrl} target="_blank" rel="noopener noreferrer">
            {shortUrl}
          </a>
        </div>
    )}
    </div>
  );
};

export default UrlShortenerForm;