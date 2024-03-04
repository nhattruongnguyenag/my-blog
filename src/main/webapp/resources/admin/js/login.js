const togglePassword = document.querySelector('#toggle-password')
const passwordInput = document.querySelector('#password')

togglePassword.addEventListener('click', function () {
    if (passwordInput.type === 'password') {
        passwordInput.type = 'text'
        togglePassword.className = 'far fa-eye-slash'
    } else {
        passwordInput.type = 'password'
        togglePassword.className = 'far fa-eye'
    }
})