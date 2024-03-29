let userName = document.querySelector(".username");
let password = document.querySelector(".pwd");
let submitBtn = document.querySelector(".submit-btn");
let errMsg = document.querySelector("#err-msg");
console.log(submitBtn);
submitBtn.onclick = function handleSubmit(){
    if(userName.value ===""){
        userName.style.border = "1px solid red";
        errMsg.innerText = "Vui lòng nhập tài khoản";
        return false;
        
    }else if(password.value===""){
        password.style.border = "1px solid red";
        errMsg.innerText = "Vui lòng nhập mật khẩu";
        return false;
    }
    else if(password.value.length <8 && password.value!=="admin"){
        password.style.border = "1px solid red";
        errMsg.innerText = "Vui lòng nhập mật khẩu ít nhất 8 kí tự";
        return false;
    }
    return true;
}

let navLinks = document.getElementById("nav-links");
function showMenu() {
    navLinks.style.right = "0";
}

function hideMenu() {
    navLinks.style.right = "-400px";
}