import {useRef,React, useState} from "react"
function ChatComponent (){
    const promptRef = useRef();
    const[chatResponse,setChatResponse] = useState();
    const generateResponse = async () =>{
        try {
            const prompt = promptRef.current?.value.trim();
            if (!prompt) return;
            const response = await fetch(`http://localhost:8080/api/genAi/ask-ai?prompt=${prompt}`);
            const data = await response.text(); // Wait for JSON response
            setChatResponse(data);
        } catch (error) {
            console.log("Error generating images: ",error);
        }
    }
    return(
        <div>
            <h1>Talk to AI</h1>
            <input type="text" placeholder="Enter your prompt" ref={promptRef} />
            <button onClick={generateResponse}>Ask AI</button>
            <div className="output">
                <p>{chatResponse}</p>
            </div>

        </div>
    );
}
export default ChatComponent;