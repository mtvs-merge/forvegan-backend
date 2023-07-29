// onKakaoLoginSuccess 함수

function handleKakaoLogin(code) {

    axios.get(`/auth/kakao/callback?code=${code}`)
        .then((response) => {
            // 응답으로 받은 JWT 토큰을 쿠키에 저장
            const token = response.data.token.accessToken;
            document.cookie = `jwtToken=${token}; max-age=3600; path=/; secure; HttpOnly`;
            // 로그인 성공 후 메인 페이지로 리디렉션 (메인 페이지 URL로 변경 필요)
            window.location.href = "http://localhost:8888";
        })
        .catch((error) => {
            console.error(error);
            // 로그인 실패 처리
        });
}
function onKakaoLoginSuccess(jwtToken) {
    localStorage.setItem('jwtToken', jwtToken);
    window.location.href = 'http://localhost:8888'; // 로그인 성공 시 메인 페이지로 이동
}

function checkLoginStatus() {

    const jwtToken = localStorage.getItem('jwtToken');

    if (jwtToken) {
        const loginButton = document.getElementById('login-button');
        loginButton.style.display = 'none';
    } else {
        const loginButton = document.getElementById('login-button');
        loginButton.style.display = 'block';
    }
}

checkLoginStatus();

// URL에서 jwtToken을 추출하고 로그인 성공 시 메인 페이지로 이동하는 로직
const urlParams = new URLSearchParams(window.location.search);
const jwtToken = urlParams.get('code');
if (jwtToken) {
    onKakaoLoginSuccess(jwtToken);
}


