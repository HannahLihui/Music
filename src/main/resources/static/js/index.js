//设置全局表单提交格式
// Vue.http.options.emulateJSON = true;

//Vue实例
new Vue({
    el: '#app',
    data() {
        return {
            name: '',
            password:'',
            activeIndex: '1'
        }
    },
    methods: {
        //从vuex中获取用户登录的用户名
        getName(){
            this.name = sessionStorage.getItem("name");
        },
        
        open3() {
        	this.password=sessionStorage.getItem("password");
              this.$prompt('请输入当前密码', '当前用户：'+sessionStorage.getItem("name")+'\n修改密码', {
                confirmButtonText: '确定',
                cancelButtonText: '取消',
              }).then(({ value }) => {
            	  if(value==this.password){
            		window.alert(this.name); 
               window.location.href="/passChange?username="+this.name;
            	 }
            	  else{
            		  this.$message({
                          type: 'info',
                          message: '密码错误'
                        });    
            	  }
            	  
              }).catch(() => {
                this.$message({
                  type: 'info',
                  message: '密码错误'
                });       
              });
            }
    },
    //声明周期钩子函数-->在data和methods渲染结束后执行
    created() {
        this.getName(); //获取用户登录名
    }
});