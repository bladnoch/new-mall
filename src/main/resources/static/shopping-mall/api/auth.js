const users = [];

function handleAuth(request) {
    const { email, password } = JSON.parse(request.body);
    if (request.method === 'POST') {
        const user = users.find(u => u.email === email);
        if (user) {
            if (user.password === password) {
                return { success: true };
            } else {
                return { success: false, message: 'Invalid password' };
            }
        } else {
            users.push({ email, password });
            return { success: true };
        }
    }
    return { success: false, message: 'Invalid request' };
}

module.exports = handleAuth;
