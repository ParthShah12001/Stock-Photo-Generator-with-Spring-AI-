AI Multi-Feature App (Spring Boot + React)
This project is an AI-powered multi-feature application that includes:

✅ AI Image Generator – Generates images based on user input

✅ Recipe Generator – Suggests recipes based on ingredients provided by the user

✅ Talk to AI – Allows users to have conversations with AI

The backend is built using Spring Boot, and the frontend is developed with React.

🚀 Features

🔹 AI Image Generator
Enter a prompt and generate an AI-generated image.

🔹 Recipe Generator
Provide ingredients, and AI will suggest a recipe based on them.

🔹 Talk to AI
Have a conversation with AI by asking questions and getting responses.

🛠️ Setup Instructions

1️⃣ Backend (Spring Boot) Setup
Clone the repository:
git clone https://github.com/your-repo/ai-multi-feature-app.git
cd ai-multi-feature-app/backend

Enter your OpenAI API key in application.properties (Mandatory)
openai.api.key=YOUR_SECRET_KEY
Run the backend using Maven or your IDE:

mvn spring-boot:run
The backend will be available at http://localhost:8080/api/genAi.

2️⃣ Frontend (React) Setup
Navigate to the frontend directory:
cd ../frontend

Install dependencies:
npm install

Run the React app:
npm start
The frontend will be available at http://localhost:3000.
📌 API Endpoints
Feature	Endpoint	Method	Description
AI Image Generator	/api/genAi/generate-image?prompt=<your_prompt>	GET	Generates an AI image based on the prompt
Recipe Generator	/api/genAi/generate-recipe?ingredients=<ingredient_list>	GET	Returns a recipe based on given ingredients
Talk to AI	/api/genAi/ask-ai?prompt=<your_message>	GET	Returns an AI-generated response

🤝 Contributing
Feel free to open issues and submit pull requests! 🚀

📄 License
This project is open-source and free to use.
