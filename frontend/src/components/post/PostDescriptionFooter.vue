<template>
    <div class="footer">
        <div class="footer__counts">
            <span>{{ viewCount }} views</span> 
            <span>{{ commentCount }} comments</span>
        </div>
        <div class="footer__like">
            <span>{{ likeCount }} </span>
            <span class="material-icons pointer footer__like-btn">{{ icon }}</span>
        </div>
    </div>
</template>

<script>
export default {
    props: [
        'viewCount',
        'commentCount',
        'likeCount',
        'isLiked',
    ],
    computed: {
        icon() {
            return this.isLiked ? 'favorite' : 'favorite_border';
        },
    }
}
</script>

<style scoped>
.footer {
    margin-top: 16px;
    display: flex;
    justify-content: space-between;
    align-items: center;
    font-weight: 300;
}
.footer__counts span {
    margin-right: 14px;
}
.footer__like {
    display: flex;
    align-items: center;
}
.footer__like-btn {
    margin-right: 0;
    margin-left: 4px;
    color: rgba(255, 0, 0, 0.87);
}
</style>