import { useState } from "react";
import { useNavigate } from "react-router-dom";

function Login() {
    const [emailId, setEmailId] = useState(""); // Email state
    const [password, setPassword] = useState(""); // Password state
    const navigate = useNavigate(); // React Router navigation hook

    // Handles email input change
    const handleEmailChange = (e) => {
        setEmailId(e.target.value);
    };

    // Handles password input change
    const handlePasswordChange = (e) => {
        setPassword(e.target.value);
    };

    // Handles form submission
    const handleSubmit = async (e) => {
        e.preventDefault(); // Prevents default form behavior
        const data = { emailId, password };

        try {
            const response = await fetch("http://localhost:8082/login", {
                method: "POST", // HTTP request method
                headers: {
                    "Content-Type": "application/json", // Set the Content-Type to application/json
                },
                body: JSON.stringify(data), // Send the data as JSON string
                credentials: "include", // Include credentials for cookie-based authentication
            });

            if (!response.ok) {
                throw new Error("Login failed");
            }

            const responseData = await response.json();

            if (responseData === false) {
                alert("Invalid credentials");
            } else {
                alert("Login successful");
                navigate("/register"); // Redirect to a dashboard or another page
            }
        } catch (error) {
            console.error("Login failed:", error);
        }
    };

    return (
        <div>
            <h2>Login Form</h2>
            <div className="container">
                <form onSubmit={handleSubmit}>
                    <label>Email ID</label>
                    <input
                        type="email"
                        placeholder="Enter Email ID"
                        value={emailId}
                        onChange={handleEmailChange}
                        required
                    />
                    <br />
                    <br />
                    <label>Password</label>
                    <input
                        type="password"
                        placeholder="Enter Password"
                        value={password}
                        onChange={handlePasswordChange}
                        required
                    />
                    <br />
                    <br />
                    <a href="/register">Dont have an account? Register</a>
                    <br />
                    <button type="submit" style={{ background: "blue", color: "white" }}>
                        Login
                    </button>
                </form>
            </div>
        </div>
    );
}

export default Login;
