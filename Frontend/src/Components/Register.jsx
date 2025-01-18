import { useState } from "react";
import { useNavigate } from "react-router-dom";

function Register() {
    const [username, setUsername] = useState(""); // Username state
    const [emailId, setEmailId] = useState(""); // Email state
    const [password, setPassword] = useState(""); // Password state
    const navigate = useNavigate(); // React Router navigation hook

    // Handles username input change
    const handleUsernameChange = (e) => {
        setUsername(e.target.value);
    };

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
        const data = { username, emailId, password };

        try {
            const response = await fetch("http://localhost:8082/register", {
                method: "POST",
                headers: {
                    "Content-Type": "application/json",
                },
                body: JSON.stringify(data),
                 
            });

            const result = await response.json();

            if (result) {
                alert("Registration successful");
                navigate("/login"); // Redirect to login page after successful registration
            } else {
                alert("Registration failed");
            }
        } catch (error) {
            console.error("Registration failed:", error);
        }
    };

    return (
        <div>
            <h2>Registration Form</h2>
            <div className="container">
                <form onSubmit={handleSubmit}>
                    <label>Username</label>
                    <input
                        type="text"
                        placeholder="Enter Username"
                        value={username}
                        onChange={handleUsernameChange}
                        required
                    />
                    <br />
                    <br />
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
                    <a href="/login">Already have an account? Login</a>
                    <br />
                    <button type="submit" style={{ background: "green", color: "white" }}>
                        Register
                    </button>
                </form>
            </div>
        </div>
    );
}

export default Register;
