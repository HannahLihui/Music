//设置全局表单提交格式
Vue.http.options.emulateJSON = true;

// Vue实例
new Vue({
    el: '#app',
    data() {
        return {
            checked: false,
            passChange: {
                username: '',
                password: '',
                repassword: ''
            }
        }
    },
  
    methods: {
    	 getName(){
             this.passChange.username = sessionStorage.getItem("name");
         },
        submitForm(passChange) {
            if(this.passChange.repassword != this.passChange.password){
                // 弹出错误信息框
                this.$emit(
                    'submit-form',
                    this.$message({
                        message: '两次输入的密码不相同',
                        type: 'warning',
                        duration: 6000
                    }),
                );
                // 清空表单状态
                this.$refs[passChange].resetFields();
            }else{
                this.$refs[passChange].validate((valid) => {
                    if (valid) {
                        //提交表单
                    	window.alert(this.passChange.username);
                        this.$http.post('/passChange', {
                            username: this.passChange.username,
                            password: this.passChange.password,
                        }).then(result => {
                            console.log(result);
                            // 判断用户是否登录成功，后端返回JSON格式数据，不然娶不到数据
                            if (result.body.success) {
                            	this.$message({
                                    message: '成功修改密码，请重新登录',
                                    type: 'success'    
                                }),
                                sessionStorage.setItem("password", this.passChange.password);
                                window.location.href = "/login";
                            } else {
                                // 弹出错误信息框
                                this.$emit(
                                    'submit-form',
                                    this.$message({
                                        message: result.body.message,
                                        type: 'warning',
                                        duration: 6000
                                    }),
                                );
                                // 清空表单状态
                                this.$refs[passChange].resetFields();
                            }
                        });
                    } else {
                        this.$emit(
                            'submit-form',
                            this.$message({
                                message: '输入信息有误！',
                                type: 'warning',
                                duration: 6000
                            }),
                        );
                        return false;
                    }
                });
            }
        },
        registerEnter(passChange){
            this.submitForm(passChange);
        }
    },
    created(){
   	 this.getName();
   }
});
