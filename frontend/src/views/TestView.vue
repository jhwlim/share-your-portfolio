<template>
    <div>
      <button @click="testApi()">API 테스트</button>
    </div>
</template>

<script>
import TestApi from '@/api/TestApi.js';

export default {
    methods: {
        testApi() {
        TestApi.test()
            .then((response) => {
            console.log(response);
            })
            .catch((error) => {
            console.log(error);
            });
        TestApi.test1();
        },
    },
}
</script>
