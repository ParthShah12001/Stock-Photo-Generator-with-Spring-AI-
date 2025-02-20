# 🚀 AI Multi-Feature App (Spring Boot + React)

An AI-powered multi-feature application that combines **image generation, recipe suggestions, and AI conversations** into one powerful tool! Built with **Spring Boot** for the backend and **React** for the frontend. 🔥

---

## ✨ Features

### ✅ AI Image Generator 🎨  
🔹 Enter a prompt and generate stunning AI-generated images instantly.

### ✅ Recipe Generator 🍽️  
🔹 Provide ingredients, and AI suggests a delicious recipe just for you!

### ✅ Talk to AI 🤖  
🔹 Have natural conversations with AI—ask anything and get insightful responses.

---

## 🛠️ Setup Instructions

### 📌 Backend (Spring Boot) Setup  
1️⃣ Clone the repository:
```sh
 git clone https://github.com/ParthShah12001/Stock-Photo-Generator-with-Spring-AI-.git
 cd ai-multi-feature-app/backend
```
2️⃣ Enter your **OpenAI API key** in `application.properties` (**Mandatory**):
```properties
openai.api.key=YOUR_SECRET_KEY
```
3️⃣ Run the backend using Maven or your IDE:
```sh
mvn spring-boot:run
```
🚀 The backend will be available at: [http://localhost:8080/api/genAi](http://localhost:8080/api/genAi)

---

### 📌 Frontend (React) Setup  
1️⃣ Navigate to the frontend directory:
```sh
cd ../frontend
```
2️⃣ Install dependencies:
```sh
npm install
```
3️⃣ Run the React app:
```sh
npm start
```
🎉 The frontend will be available at: [http://localhost:3000](http://localhost:3000)

---

## 🌍 API Endpoints

| Feature            | Endpoint | Method | Description |
|-------------------|---------------------------------------------|--------|-----------------------------------------|
| 🎨 **AI Image Generator** | `/api/genAi/generate-image?prompt=<your_prompt>` | `GET` | Generates an AI image based on a prompt |
| 🍽️ **Recipe Generator** | `/api/genAi/generate-recipe?ingredients={ingredient_list}&cuisine={cuisine}&dietaryRestriction={dietaryRestriction}` | `GET` | Returns a recipe based on given ingredients |
| 🤖 **Talk to AI** | `/api/genAi/ask-ai?prompt=<your_message>` | `GET` | Returns an AI-generated response |

---

## 🤝 Contributing
💡 **Want to improve this project?** Feel free to fork the repo, open issues, and submit pull requests! 🚀

---

## 📄 License
This project is **open-source** and free to use. 🎯

---

💬 **For any questions or suggestions, feel free to reach out!**

