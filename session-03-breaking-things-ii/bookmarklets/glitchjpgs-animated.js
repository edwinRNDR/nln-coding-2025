function replaceAt(a, index, replacement) {
    return a.substring(0, index) + replacement + a.substring(index + replacement.length);
}

function arrayBufferToBase64( buffer ) {
    var binary = '';
    var bytes = new Uint8Array( buffer );
    var len = bytes.byteLength;
    for (var i = 0; i < len; i++) {
        binary += String.fromCharCode( bytes[ i ] );
    }
    return btoa( binary );
}

async function downloadImage(img, originalSrc) {
    const image = await fetch(originalSrc);
    const imageBlob = await image.blob();
    const ab = await imageBlob.arrayBuffer();
    const t = imageBlob.type;
    
    url = arrayBufferToBase64(ab);

    for (i = 0; i < 100; ++i) {
          glitchIdx = Math.floor(Math.random() * url.length);
          url = replaceAt(url, glitchIdx, 'f');
      }
    img.src = "data:" +t + ";base64," + url;
  }
 

imgs = [...document.getElementsByTagName("img")];

imgs.forEach( e => {
    const originalSrc = e.src
    function animate() {
        downloadImage(e, originalSrc);
    }

    if (!e.src.includes("data:")) {
        setInterval(animate, 500);
        
    }
})