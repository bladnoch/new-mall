
document.getElementById('register-form').addEventListener('submit', (e) => {
    e.preventDefault();
    const email = document.getElementById('email').value;
    const password = document.getElementById('password').value;

    fetch(`${BASE_URL}/auth/register`, {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify({ email, password })
    })
        .then(response => response.json())
        .then(data => {
            if (data.message === '200 ok') {
                alert('Registration successful');
                window.location.href = 'login.html';
            } else {
                alert(`Registration failed: ${data.error}`);
            }
        })
        .catch(error => {
            console.error('Error:', error);
            alert('An error occurred during registration');
        });
});

document.getElementById('login-form').addEventListener('submit', (e) => {
    e.preventDefault();
    const email = document.getElementById('email').value;
    const password = document.getElementById('password').value;

    fetch(`${BASE_URL}/auth/login`, {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify({ email, password })
    })
        .then(response => response.json())
        .then(data => {
            if (data.token) {
                alert('Login successful');
                // Store the token for future use
                localStorage.setItem('token', data.token);
                window.location.href = 'index.html';
            } else {
                alert(`Login failed: ${data.error}`);
            }
        })
        .catch(error => {
            console.error('Error:', error);
            alert('An error occurred during login');
        });
});


// document.getElementById('login-form').addEventListener('submit', (e) => {
//   e.preventDefault();
//   const email = document.getElementById('email').value;
//   const password = document.getElementById('password').value;
//
//   // Perform login API call
//   fetch('api/auth.js', {
//       method: 'POST',
//       body: JSON.stringify({ email, password }),
//       headers: {
//           'Content-Type': 'application/json'
//       }
//   }).then(response => response.json())
//   .then(data => {
//       if(data.success) {
//           alert('Login successful');
//           window.location.href = 'index.html';
//       } else {
//           alert('Login failed');
//       }
//   });
// });
//
// document.getElementById('register-form').addEventListener('submit', (e) => {
//   e.preventDefault();
//   const email = document.getElementById('email').value;
//   const password = document.getElementById('password').value;
//
//   // Perform registration API call
//   fetch('api/auth.js', {
//       method: 'POST',
//       body: JSON.stringify({ email, password }),
//       headers: {
//           'Content-Type': 'application/json'
//       }
//   }).then(response => response.json())
//   .then(data => {
//       if(data.success) {
//           alert('Registration successful');
//           window.location.href = 'login.html';
//       } else {
//           alert('Registration failed');
//       }
//   });
// });
