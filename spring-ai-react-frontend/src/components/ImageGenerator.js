import React, { useRef, useState } from "react"
function ImageGenerator (){
    const promptRef = useRef();
    const[imageUrls,setImageUrls] = useState([]);

    const generateImage = async () =>{
        try {
            const prompt = promptRef.current?.value.trim();
            if (!prompt) return;
            const response = await fetch(`http://localhost:8080/api/genAi/generate-image?prompt=${prompt}`);
            const data = await response.json(); // Wait for JSON response
            setImageUrls(data);
        } catch (error) {
            console.log("Error generating images: ",error);
        }
    }
    return(
        <div className="tab-content">
            <h1>Generate Image</h1>
            <input type="text" placeholder="Enter prompt for image" ref={promptRef} />
            <button onClick={generateImage}>Generate Image</button>
            <div className="image-grid">
                {imageUrls.map((url,index)=>(
                    <img key={index} src={url} alt={`Generated image ${index}`}/>
                ))}
                {[...Array(4-imageUrls.length)].map((_,index)=>(
                    <div key={index + imageUrls.length} className="empty-image-slot"></div>
                ))}
            </div>
        </div>
    );
}
export default ImageGenerator;