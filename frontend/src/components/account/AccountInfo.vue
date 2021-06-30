<template>
    <ul class="account-info">
        <li class="account-info__item">
            <span>이름</span>
            <div><input type="text" readonly></div>
        </li>
        <li class="account-info__item">
            <span>비밀번호</span>
            <div><button>수정</button></div>
        </li>
        <li class="account-info__item">
            <span>이메일</span>
            <div><input type="text" readonly></div>
        </li>
    </ul>
</template>

<script>
export default {

}
</script>

<style scoped>
.account-info {
    margin: 26px auto 0;
    width: 320px;
}
.account-info__item {
    margin-bottom: 20px;
}
.account-info__item:last-child { margin-bottom: 0; }
.account-info__item span {
    font-weight: 500;
    font-size: 18px;
}
.account-info__item div {
    margin-top: 10px;
    display: flex;
    align-items: center;
    justify-content: space-between;
}
.account-info__item input {
    width: 100%;
    box-sizing: border-box;
    padding: 4px 6px;
    font-family: inherit;
    font-size: 14px;
}
.account-info__item button {
    width: 100%;
    height: 36px;
}
</style>