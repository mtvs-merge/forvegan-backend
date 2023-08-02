document.addEventListener("DOMContentLoaded", function() {
    // JWT 토큰 체크 (예: 쿠키에서 가져오기)
    let jwtToken = getCookie("jwtToken");

    // 버튼 요소를 가져옴
    const loginButton = document.getElementById("login-button");
    const logoutButton = document.getElementById("logout-button");
    const checkButton = document.getElementById("check-button")

    if (jwtToken) {
        // 로그인 상태라면 로그인 버튼 숨기기
        loginButton.style.display = "none";
        logoutButton.style.display = "block";
    } else {
        // 로그아웃 상태라면 로그인 버튼 보이기
        loginButton.style.display = "block";
        logoutButton.style.display = "none";
    }
        loginButton.addEventListener("click", function() {
            location.href = "/login";
        });


    logoutButton.addEventListener("click", function() {
        deleteCookie("jwtToken");
        location.reload();
    });

    function deleteCookie(name) {
        document.cookie = name + '=; expires=Thu, 01 Jan 1970 00:00:01 GMT;'
    }
});

// 쿠키에서 값을 가져오는 함수
function getCookie(name) {
    let value = "; " + document.cookie;
    let parts = value.split("; " + name + "=");
    if (parts.length == 2) return parts.pop().split(";").shift();
}
