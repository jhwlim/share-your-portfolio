<template>
    <v-layout class="justify-center">
        <v-sheet 
            width="600"
            elevation="1"
            class="pa-2"
        >
            <v-hover>
                <template v-slot:default="{ hover }">
                    <v-card elevation="0" class="py-10">
                        <div class="mx-auto" style="position: relative; width: 100px;">
                            <user-image 
                                :id="user.id"
                                :size="100"
                            ></user-image>

                            <v-fade-transition>
                                <v-overlay
                                    v-if="hover"
                                    absolute
                                    class="rounded-lg"
                                >
                                    <v-btn outlined dark>수정</v-btn>
                                </v-overlay>
                            </v-fade-transition>
                        </div>
                    </v-card>
                </template>
            </v-hover>

            <v-card elevation="0" width="300" class="mx-auto">
                <v-card-text>
                    <v-text-field
                        label="이메일"
                        :value="user.username"
                        readonly
                        class="mb-4"
                    ></v-text-field>

                    <v-dialog
                        v-model="dialog"
                        persistent
                        width="360"
                    >
                        <template v-slot:activator="{ on, attrs }">
                            <v-btn block elevation="0" color="secondary" v-on="on" :bind="attrs">
                                비밀번호 변경
                            </v-btn>
                        </template>
                        <v-card>
                            <v-card-title class="font-weight-bold text-h5 justify-center">
                                비밀번호 변경
                            </v-card-title>
                            <v-card-text>
                                <v-form ref="form">
                                    <v-text-field
                                        label="현재 비밀번호"
                                        type="password"
                                        v-model="passwordChangeForm.currentPassword"
                                        :rules="rules.currentPassword"
                                        autocomplete="new-password"
                                    ></v-text-field>
                                    <v-text-field
                                        label="새 비밀번호"
                                        type="password"
                                        v-model="passwordChangeForm.newPassword"
                                        :rules="rules.newPassword"
                                    ></v-text-field>
                                    <v-text-field
                                        label="새 비밀번호 확인"
                                        type="password"
                                        :rules="rules.newPasswordConfirmation"
                                    ></v-text-field>
                                </v-form>
                            </v-card-text>
                            <v-card-actions>
                                <v-spacer></v-spacer>
                                <v-btn color="error" @click="dialog = false">취소</v-btn>
                                <v-btn color="success" @click="submitChangePasswordForm">저장</v-btn>
                            </v-card-actions>
                        </v-card>
                    </v-dialog>
                </v-card-text>
            </v-card>
        </v-sheet>
    </v-layout>
</template>

<script>
import UserImage from '@/components/UserImage.vue';
import { mapState } from 'vuex';

export default {
    name: 'AccountView',
    components: {
        UserImage,
    },
    data: function() {
        return {
           dialog: false,
           passwordChangeForm: {
               currentPassword: '',
               newPassword: '',
           },
           rules: {
               currentPassword: [
                   value => !!value || '현재 비밀번호를 입력해주세요.',
               ],
               newPassword: [
                   value => !!value || '새로운 비밀번호를 입력해주세요.',    
               ],
               newPasswordConfirmation: [
                   value => value === this.passwordChangeForm.newPassword || '비밀번호가 일치하지 않습니다.',
               ],
           }
        }
    },
    computed: {
        ...mapState({
            user: state => state.user.user,
        }),
    },
    methods: {
        validate() {
            this.$refs.form.validate();
        },
        submitChangePasswordForm() {
            this.validate();
        }
    }
}
</script>