//-------- HTML 요소 셀렉팅 ---------//

const username = document.querySelector('#username');

const elFailureMessage = document.querySelector('.failure-message');
const elSuccessMessage = document.querySelector('.success-message');

const password = document.querySelector('#password');
const re_password = document.querySelector('#re_password');

const elRe_PWFailureMsg = document.querySelector('.mismatch-message');
const elRe_PWSuccessMsg = document.querySelector('.match-message');

const elPWFailureLeng = document.querySelector('.password-failure-length');
const elPWFailureComb = document.querySelector('.password-failure-comb');
const elPWFailureContn = document.querySelector('.password-failure-contn');
const elPWFailureUpper = document.querySelector('.password-failure-upper');
const elPWSuccessMessage = document.querySelector('.password-success-message');

const nickname = document.querySelector('#nickname')

const nicknameFMessage = document.querySelector('.nickF-message');
const nicknameSMessage = document.querySelector('.nickS-message');

const name1 = document.querySelector('#name');

const elIllegibleMessage = document.querySelector('.illegible-message');
const elReadableMessage = document.querySelector('.readable-message');

const email = document.querySelector('#email');

const emailFMessage = document.querySelector('.emailF-message');
const emailSMessage = document.querySelector('.emailS-message');

const zipcode = document.querySelector('#zipcode');

const zipcodeFMessage = document.querySelector('.zipcodeF-message');
const zipcodeSMessage = document.querySelector('.zipcodeS-message');

const address = document.querySelector('#address');

const addressFMessage = document.querySelector('.addressF-message');
const addressSMessage = document.querySelector('.addressS-message');

const detailAddress = document.querySelector('#detailAddress');

const dAddressFMessage = document.querySelector('.dAddressF-message');
const dAddressSMessage = document.querySelector('.dAddressS-message');

const elSubmitButton = document.querySelector('#subit-button');

let nickChk = null;
let emailChk = null;

//-------- 유효성 검사 ---------//

// { 아이디 } input 유효성 검사
function usernameFn() {
    if (isMoreThan4Length(username.value) && isUserNameChar(username.value)) {
        elSuccessMessage.classList.remove('hide');
        elFailureMessage.classList.add('hide')
    } else {
        elFailureMessage.classList.remove('hide');
        elSuccessMessage.classList.add('hide');
    }

    isSubmitButton();
}

username.addEventListener('click', usernameFn);
username.addEventListener('keyup', usernameFn);

// { 비밀번호 } input 유효성 검사
function passwordFn() {

    if (isMoreThan10Length(password.value)) {
        elPWFailureLeng.classList.add('hide');
    } else {
        elPWFailureLeng.classList.remove('hide');
    }


    if ((isPasswordEng(password.value) + isPasswordNum(password.value) + isPasswordSpeci(password.value) >= 2) &&
        (isPasswordBlank(password.value)) &&
        (isPasswordChar(password.value))
    ) {
        elPWFailureComb.classList.add('hide');
    } else {
        elPWFailureComb.classList.remove('hide');
    }

    if (isPasswordRepeat(password.value)) {
        elPWFailureContn.classList.remove('hide');
    } else {
        elPWFailureContn.classList.add('hide');
    }

    if ((isPasswordUpper(password.value))) {
        elPWFailureUpper.classList.add('hide');
    } else {
        elPWFailureUpper.classList.remove('hide');
    }

    if ((isMoreThan10Length(password.value)) &&
        (isPasswordEng(password.value) + isPasswordNum(password.value) + isPasswordSpeci(password.value) >= 2) &&
        (isPasswordChar(password.value)) &&
        (isPasswordBlank(password.value)) &&
        (!isPasswordRepeat(password.value)) &&
        ((isPasswordUpper(password.value)))
    ) {
        elPWSuccessMessage.classList.remove('hide');
    } else {
        elPWSuccessMessage.classList.add('hide');
    }

    isSubmitButton();
}

password.addEventListener('click', passwordFn)
password.addEventListener('keyup', passwordFn)
password.addEventListener('keyup', re_passwordFn)

// { 비밀번호 확인 } input 유효성 검사
function re_passwordFn() {
    if (isMatch(password.value, re_password.value) && isPasswordBlank(re_password.value)) {
        //console.log('두 비밀번호가 동일.');
        elRe_PWFailureMsg.classList.add('hide');
        elRe_PWSuccessMsg.classList.remove('hide');
    } else {
        //console.log('두 비밀번호가 다름');
        elRe_PWFailureMsg.classList.remove('hide');
        elRe_PWSuccessMsg.classList.add('hide');
    }

    isSubmitButton();
}

re_password.onclick = re_passwordFn;
re_password.onkeyup = re_passwordFn;

// 이메일 유효성 검사
function emailFn() {
    if (isEmailOk(email.value)) {
        emailFMessage.classList.add('hide');
        emailSMessage.classList.remove('hide');
    } else {
        emailFMessage.classList.remove('hide');
        emailSMessage.classList.add('hide');
    }
    isSubmitButton();
}

email.addEventListener('click', emailFn);
email.addEventListener('keyup', emailFn);

// 닉네임
function nicknameFn() {
    if (isMoreThan4Length(nickname.value)) {
        nicknameSMessage.classList.remove('hide');
        nicknameFMessage.classList.add('hide')
    } else {
        nicknameFMessage.classList.remove('hide');
        nicknameSMessage.classList.add('hide');
    }

    isSubmitButton();
}

nickname.addEventListener('click', nicknameFn);
nickname.addEventListener('keyup', nicknameFn);


// 이름 유효성 검사
function name1Fn() {
    if (isName1Char(name1.value)) {
        elIllegibleMessage.classList.add('hide');
        elReadableMessage.classList.remove('hide');
    } else {
        elIllegibleMessage.classList.remove('hide');
        elReadableMessage.classList.add('hide');
    }

    isSubmitButton();
}

name1.addEventListener('click', name1Fn);
name1.addEventListener('keyup', name1Fn);

function zipcodeFn() {
    if (nullChk(zipcode.value)) {
        zipcodeSMessage.classList.remove('hide');
        zipcodeFMessage.classList.add('hide')
    } else {
        zipcodeFMessage.classList.remove('hide');
        zipcodeSMessage.classList.add('hide');
    }

    isSubmitButton();
}

zipcode.addEventListener('click', zipcodeFn);
zipcode.addEventListener('keyup', zipcodeFn);

function addressFn() {
    if (nullChk(address.value)) {
        addressSMessage.classList.remove('hide');
        addressFMessage.classList.add('hide')
    } else {
        addressFMessage.classList.remove('hide');
        addressSMessage.classList.add('hide');
    }

    isSubmitButton();
}

address.addEventListener('click', addressFn);
address.addEventListener('keyup', addressFn);

function detailAddressFn() {
    if (nullChk(detailAddress.value)) {
        dAddressSMessage.classList.remove('hide');
        dAddressFMessage.classList.add('hide')
    } else {
        dAddressFMessage.classList.remove('hide');
        dAddressSMessage.classList.add('hide');
    }

    isSubmitButton();
}

detailAddress.addEventListener('click', detailAddressFn);
detailAddress.addEventListener('keyup', detailAddressFn);

function execPostCode() {
    new daum.Postcode({
        oncomplete: function (data) {
            // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

            // 도로명 주소의 노출 규칙에 따라 주소를 조합한다.
            // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
            var fullRoadAddr = data.roadAddress; // 도로명 주소 변수
            var extraRoadAddr = ''; // 도로명 조합형 주소 변수

            // 법정동명이 있을 경우 추가한다. (법정리는 제외)
            // 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
            if (data.bname !== '' && /[동|로|가]$/g.test(data.bname)) {
                extraRoadAddr += data.bname;
            }
            // 건물명이 있고, 공동주택일 경우 추가한다.
            if (data.buildingName !== '' && data.apartment === 'Y') {
                extraRoadAddr += (extraRoadAddr !== '' ? ', ' + data.buildingName : data.buildingName);
            }
            // 도로명, 지번 조합형 주소가 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
            if (extraRoadAddr !== '') {
                extraRoadAddr = ' (' + extraRoadAddr + ')';
            }
            // 도로명, 지번 주소의 유무에 따라 해당 조합형 주소를 추가한다.
            if (fullRoadAddr !== '') {
                fullRoadAddr += extraRoadAddr;
            }

            // 우편번호와 주소 정보를 해당 필드에 넣는다.
            console.log(data.zonecode);
            console.log(fullRoadAddr);


            $("[name=zipcode]").val(data.zonecode);
            $("[name=address]").val(fullRoadAddr);

            document.getElementById('zipcode').value = data.zonecode; //5자리 새우편번호 사용
            document.getElementById('address').value = fullRoadAddr;
            // document.getElementById('signUpUserCompanyAddressDetail').value = data.jibunAddress;
        }
    }).open();
}

$('#nickname').on("propertychange, change keyup paste input", function () {

    var id = $('#id').val();
    var nickname = $('#nickname').val();
    var data = {nickname: nickname}
    var token = $("meta[name='_csrf']").attr("content");
    var header = $("meta[name='_csrf_header']").attr("content");

    $(document).ajaxSend(function (event, xhr, options) {
        xhr.setRequestHeader(header, token);
    })

    $.ajax({
        type: "post",
        url: "/auth/member/saveProc/nicknameCheck",
        data: data,
        success: function (resultNick) {
            console.log("성공 여부 " + resultNick);
            if (resultNick == "true") {
                $('.nick_input_re_1').css("display", "inline-block");
                $('.nick_input_re_2').css("display", "none");
                $('.nick_input_re_3').css("display", "none");
                nickChk = "true";
            } else {
                var data1 = {id: id, nickname: nickname};
                $.ajax({
                    type: "post",
                    url: "/auth/member/modifyProc/nicknameCheck",
                    data: data1,
                    success: function (resultNickCheck) {
                        if (resultNickCheck == "true") {
                            $('.nick_input_re_3').css("display", "inline-block");
                            $('.nick_input_re_2').css("display", "none");
                            $('.nick_input_re_1').css("display", "none");
                            nickChk = "true";
                        } else{
                            $('.nick_input_re_2').css("display", "inline-block");
                            $('.nick_input_re_1').css("display", "none");
                            $('.nick_input_re_3').css("display", "none");
                            nickChk = "false";
                        }
                    }
                })
            }
        }
    });
});

$('#email').on("propertychange, change keyup paste input", function () {

    var id = $('#id').val();
    var email = $('#email').val();
    var data = {email: email}
    var token = $("meta[name='_csrf']").attr("content");
    var header = $("meta[name='_csrf_header']").attr("content");

    $(document).ajaxSend(function (event, xhr, options) {
        xhr.setRequestHeader(header, token);
    })

    $.ajax({
        type: "post",
        url: "/auth/member/saveProc/emailCheck",
        data: data,
        success: function (resultEmail) {
            console.log("성공 여부 " + resultEmail);
            if (resultEmail == "true") {
                $('.email_input_re_1').css("display", "inline-block");
                $('.email_input_re_2').css("display", "none");
                $('.email_input_re_3').css("display", "none");
                emailChk = "true";
            } else{
                var data1 = {id: id, email: email};
                $.ajax({
                    type: "post",
                    url: "/auth/member/modifyProc/emailCheck",
                    data: data1,
                    success: function (resultEmailCheck) {
                        if (resultEmailCheck == "true") {
                            $('.email_input_re_3').css("display", "inline-block");
                            $('.email_input_re_2').css("display", "none");
                            $('.email_input_re_1').css("display", "none");
                            emailChk = "true";
                        } else{
                            $('.email_input_re_2').css("display", "inline-block");
                            $('.email_input_re_1').css("display", "none");
                            $('.email_input_re_3').css("display", "none");
                            emailChk = "false";
                        }
                    }
                })
            }
        }
    });
});

//-------- 최종 유효성 검사에서 사용하는 함수 ---------//

// 모든 조건이 충족되었는지 확인하는 함수
function isAllCheck() {
    console.log("validationstart");
    if (isMoreThan4Length(username.value) && isUserNameChar(username.value)) { // 아이디
        if ((isMoreThan10Length(password.value)) &&
            (isPasswordEng(password.value) + isPasswordNum(password.value) + isPasswordSpeci(password.value) >= 2) &&
            (isPasswordChar(password.value)) &&
            (isPasswordBlank(password.value)) &&
            (!isPasswordRepeat(password.value)) &&
            ((isPasswordUpper(password.value)))
        ) { // 비밀번호
            if (isMatch(password.value, re_password.value)) { // 비밀번호 확인
                //console.log('true!!');
                if (isName1Char(name1.value)) {
                    if (isEmailOk(email.value)) {
                        if (isMoreThan4Length(nickname.value)) {
                            if (nullChk(zipcode.value)) {
                                if (nullChk(address.value)) {
                                    if (nullChk(detailAddress.value)) {
                                        if(nickChk === "true"){
                                            if (emailChk === "true"){
                                                console.log("validationend");
                                                return true;
                                            } else {
                                                console.log("emailerr'")
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    } else {
        console.log('false!!');
        return false;
    }
}


// [회원가입 버튼] 배경 활성화 함수
function isSubmitButton() {
    if (isAllCheck()) {
        elSubmitButton.classList.add('allCheck');
    } else {
        elSubmitButton.classList.remove('allCheck');
    }
}

// let index = {
//     init: function () {
//         $("#subit-button").on("click", () => {
//             if (isAllCheck() == true) {
//                 this.save();
//             } else {
//                 console.log("회원가입안됨")
//             }
//         });
//     },
//
//     save: function () {
//         let data = {
//             username,
//             password,
//             email,
//             nickname,
//             zipcode,
//             address,
//             detailAddress
//         }
//
//         $.ajax({
//             type: "POST",
//             url: "/auth/api/v1/user",
//             data: JSON.stringify(data),
//             contentType: "application/json; charset=utf-8",
//             dataType: "json"
//         }).done(function (res) {
//             alert("회원가입 완료");
//             location.href = "/auth/user/login";
//         }).fail(function (err) {
//             alert(JSON.stringify(err));
//         });
//
//     }
// }
// index.init();

document.getElementById("joinForm").onsubmit = function () {
    if (isAllCheck()) {
        return true;
    } else {
        alert('모든 조건이 충족되어야합니다.');
        return false;
    }
}
;


let index = {
    init: function () {
        $("#subit-button").on("click", () => {
            let form = document.querySelector("#joinForm");
            if (form.checkValidity() == false) {
                console.log("수정 안됨")
            } else {
                this.update();
            }
        })
    },

    update: function () {
        var token = $("meta[name='_csrf']").attr("content");
        var header = $("meta[name='_csrf_header']").attr("content");

        var url = "/api/v1/member";

        let data = {
            id: $("#id").val(),
            password: $("#password").val(),
            nickname: $("#nickname").val(),
            name: $("#name").val(),
            zipcode: $("#zipcode").val(),
            address: $("#address").val(),
            detailAddress: $("#detailAddress").val(),
            email: $("#email").val()
        }

        $.ajax({
            type: "PUT",
            url: url,
            data: JSON.stringify(data),
            beforeSend: function (xhr) {
                /* 데이터를 전송하기 전에 헤더에 csrf값을 설정 */
                xhr.setRequestHeader(header, token);
            },
            dataType: "json",
            cache: false,
            contentType: 'application/json; charset=utf-8',
            success: function (res) {
                alert("회원수정이 완료되었습니다")
                location.href = "/";
            }, error: function (err) {
                alert(JSON.stringify(err))
            }
        })
    }
}
index.init();


//-------- 유효성 검사에서 사용하는 함수다 ---------//

// null 이 아닌경우
function nullChk(value) {
    return value.length >= 1;
}

// [아이디] 길이가 4자 이상이면 true를 리턴하는 함수
function isMoreThan4Length(value) {
// 아이디 입력창에 사용자가 입력을 할 때
// 글자 수가 4개이상인지 판단한다.
// 글자가 4개 이상이면 success메세지가 보여야 한다.
    return value.length >= 4;
}

// [아이디] '영문, 숫자'만 있으면 true를 리턴하는 함수
function isUserNameChar(username) {
    var letters = /^[A-Za-z0-9]+$/;

    if (username.match(letters)) {
        return true;
    } else {
        return false;
    }
}

// [비밀번호] 길이가 10자 이상이면 true를 리턴하는 함수
function isMoreThan10Length(password) {
    return password.length >= 10;
}

// [비밀번호] 영문이 있으면 true를 리턴하는 함수
function isPasswordEng(password) {
    var letters = /[A-Za-z]/; // 잘 모르겠지만 이것은 정규표현식으로 AZ - az 모든 알파벳을 담고 있다.

    if (letters.test(password)) {  // 정규표현식에 영어문자가 모두 들었고. 정규표현식의 메소드인 test()로 비밀번호 문자에 영어가 있는지 판단한다.
        return true;
    } else {
        return false;
    }
}

// [비밀번호] 숫자가 있으면 true를 리턴하는 함수
function isPasswordNum(password) {
    var letters = /[0-9]/;

    if (letters.test(password)) {
        return true;
    } else {
        return false;
    }
}

// [비밀번호] 특수문자가 있으면 true를 리턴하는 함수
function isPasswordSpeci(password) {
    var letters = /[~!@#$%^&*()\-_=+\\\|\[\]{};:\'",.<>\/?]/;

    if (letters.test(password)) {
        return true;
    } else {
        return false;
    }
}

// [비밀번호][비밀번호 확인] 스페이스가 없을 경우 true를 리턴하는 함수
function isPasswordBlank(password) {
    if (password.search(/\s/) === -1) {
        return true;
    } else {
        return false;
    }
}

// [비밀번호] '영문, 숫자, 특수문자'만 있으면 true를 리턴하는 함수
function isPasswordChar(password) {
    var letters = /^[A-Za-z0-9~!@#$%^&*()\-_=+\\\|\[\]{};:\'",.<>\/?]+$/;

    if (password.match(letters)) {
//console.log('가능한 것만 있네!');
        return true;
    } else {
//console.log('안되는 것도 있네?');
        return false;
    }
}

// [비밀번호] 동일한 숫자 3개 이상 연속 사용하면 true를 리턴하는 함수
function isPasswordRepeat(password) {
// password의 길이만큼 반복되는 반복문이 있어야 한다.
// 문자 하나와 나 자신+1과 나자신 +2와 비교한다.
// 숫자인지 아닌지 판단한다.숫자이면 true 아니면 false
    for (let i = 0; i < password.length - 2; i++) {
        if (password[i] === password[i + 1] && password[i] === password[i + 2]) {
            if (!isNaN(Number(password[i]))) {
                return true;
            }
        }
    }
    return false;
}

// [비밀번호] 영문자 중에 대문자 하나이상 포함되면 true를 리턴하는 함수
function isPasswordUpper(password) {
    var letters = /[A-Z]/;

    if (letters.test(password)) {
        return true;
    } else {
        return false;
    }
}

// [비밀번호 확인] 매치가 동일하면 true를 리턴하는 함수
function isMatch(password1, password2) {
    if (password1 && password2) {
        if (password1 === password2) {
            return true;
        }
    } else {
        return false;
    }
}

// 이메일 형식 유효성
function isEmailOk(email) {
    var letters = /^[A-Za-z0-9_\.\-]+@[A-Za-z0-9\-]+\.[A-Za-z0-9\-]+/;
    if (letters.test(email) == true) {
        return true;
    }
    return false;
}

// 이름이 숫자가 들어간경우
function isName1Char(name1) {
    var letters = /^[가-힣]+$/;
    if (name1.match(letters)) {
        return true;
    } else {
        return false;
    }
}

