import React, { useRef, useState } from "react"
function RecipeGenerator (){
    const ingredientsRef = useRef();
    const cuisineRef= useRef();
    const dietaryRestrictionRef = useRef();
    const[recipe,setRecipe] = useState();
    const generateRecipe = async () =>{
        try {
            const ingredients = ingredientsRef.current?.value.trim();
            const cuisine = cuisineRef.current?.value.trim();
            const dietaryRestriction = dietaryRestrictionRef.current?.value.trim();
            if (!ingredients) return;
            const response = await fetch(`http://localhost:8080/api/genAi/ask-ai?ingredients=${ingredients}&cuisine=${cuisine}&dietaryRestriction=${dietaryRestriction}`);
            const data = await response.text();
            setRecipe(data);
        } catch (error) {
            console.log("Error generating images: ",error);
        }
    }
    return(
        <div>
            <h2>Create a Recipe</h2>
            <input type="text" placeholder="Enter your ingredients" ref={promptRef} />
            <input type="text" placeholder="Enter your cuisine" ref={promptRef} />
            <input type="text" placeholder="Enter your dietary Restriction" ref={promptRef} />
            <button onClick={generateRecipe}>Generate Recipe</button>
            <div className="output">
                <pre className="recipe-text">{recipe}</pre>
            </div>
        </div>
    );
}
export default RecipeGenerator;