function register() {
    event.preventDefault();
    const errorBox = document.getElementById("Error");
    errorBox.textContent = "";
    errorBox.style.color = "red";
    const name = document.getElementById("name").value.trim();
    const email = document.getElementById("email").value.trim();
    const password = document.getElementById("password").value.trim();

    if (!name || !email || !password) {
        errorBox.textContent = "Please fill in all required fields!";
        return;
    }

    if (password.length < 6) {
        errorBox.textContent = "Password must be at least 6 characters long!";
        return;
    }

    if(!email.endsWith("@gmail.com")){
        errorBox.textContent="Enter valid Email";
        return;
    }

    const userData={name,email,password};

    fetch("http://localhost:8080/api/register", {
        method: "POST",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify(userData)
    })
        .then(response => {
            if (!response.ok) {
                throw new Error("Registration failed!");
            }
            return response.text();
        })
        .then(data => {
            errorBox.style.color = "green";
            errorBox.textContent = "✅ Registration successful!";
            setTimeout(() => {
                window.location.href = "login.html";
            }, 1000);
        })
        .catch(error => {
            errorBox.textContent = "❌ " + error.message;
        });
}
