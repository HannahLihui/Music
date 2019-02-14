Vue.http.options.emulateJSON = true;
new Vue({
	el: '#app',
	
data() {
	 
    return {
    	comments:[
    	    {
    	        id: '', //主键id
    	        date: '',  //评论时间
    	        ownerId: '', //文章的id
    	        fromId: '',  //评论者id
    	        fromName: '',   //评论者昵称
    	        fromAvatar: '', //评论者头像
    	        likeNum: '', //点赞人数
    	        content: '',  //评论内容
    	        reply: []
    	      }
    	    ],
    	
    	inputComment: '',
        showItemId: '',
    	    musicUrl:'',
    		reg:'',
    		url:'',
    		r:'',
    		id:'',
    		name:'',
    		
    		 news: [{
                 id: '',
                 title: '',
                 date: '',
                 img: '', 
                 content: ''
             }],
             playmusic: {
                 id: '',
                 name: '',
                 num: '',
                 url:'',
                 img: '',
                 brand: '',
                 singer: ''
             },
    	
             mymusic: [{
                 id: '',
                 name: '',
                 num: '',
                 url:'',
                 img: '',
                 brand: '',
                 singer: ''
             }],
    	
    	 music:{
             isPlay:false,
             currentTime:0,
             maxTime:0,
             volume:100
           },
    	
      tableData: [{
    	  id: '1',
          name: '林俊杰',
          num: '100',
          img: '',
          brand: '',
          singer: '',
          url:'../dist/music/1.mp3'
      }, {
    	  id: '',
          name: '',
          num: '',
          img: '',
          brand: '',
          singer: '',
          url:''
      }, {
    	  id: '',
          name: '',
          num: '',
          img: '',
          brand: '',
          singer: '',
          url:''
      }, {
    	  id: '',
          name: '',
          num: '',
          img: '',
          brand: '',
          singer: '',
          url:''
      }]
    }
  },
  created() {
      // this.findAll();
	  this.findSrc();
	  this.searchComment();
	  console.log(this.comments)
    
     
  },
  methods: {
	  searchComment() {
		 
          this.$http.post('/message/findById?id='+this.id).then(result => {
              console.log(result);
              this.comments = result.body;
          });

      },
	  /**
       * 点赞
       */
      likeClick(item) {
        if (item.isLike === null) {
          Vue.$set(item, "isLike", true);
          item.likeNum++
        } else {
          if (item.isLike) {
            item.likeNum--
          } else {
            item.likeNum++
          }
          item.isLike = !item.isLike;
        }
      },

      /**
       * 点击取消按钮
       */
      cancel() {
        this.showItemId = ''
      },

      /**
       * 提交评论
       */
      commitComment() {
    	  this.name=sessionStorage.getItem("name");
    	  if(this.name==null)
    		  window.alert("请您后登录后再评论");
    	  if(this.name!=null){
    	  this.$http.post('/message/create?id='+this.id+'&content=' + this.inputComment+'&name=' + this.name).then(result => {
    		  
              console.log(result);
              this.searchComment();
             
          });
    	  }
      },

      /**
       * 点击评论按钮显示输入框
       * item: 当前大评论
       * reply: 当前回复的评论
       */
      showCommentInput(item, reply) {
    	  this.name=sessionStorage.getItem("name");
    	  if(this.name!=null){
        if (reply) {
          this.inputComment = "@" + reply.fromName + " "
        } else {
          this.inputComment = ''
        }
        this.showItemId = item.id;
    	  }
      },

	  findSrc(){
		   this.reg = new RegExp("(^|&)id=([^&]*)(&|$)");
		        this.url =  decodeURI(window.location.search);
		         this. r = this.url.substr(1).match(this.reg);
		          
		          this.id= decodeURI(this.r[2]);
		  console.log(this.id);
		  this.$http.post('/music/findById?id='+this.id).then(result => {
        	  this.playmusic=result.body;
        	  console.log(result.body);
        	 
          });
		          
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
          },
	  search() {
          
          this.$http.post('/news/findAll').then(result => {
              console.log(result);
              this.news= result.body;
             
             
          });

      },
      Musicsearch() {
         
          this.$http.post('/music/findAll').then(result => {
              console.log(result);
              this.mymusic = result.body;
              sessionStorage.setItem("src", this.mymusic.url);
             
             
          });

      },
  
    listenMusic(){
        if(!this.$refs.music){
          return
        }
        if(this.$refs.music.readyState){
          this.music.maxTime = this.$refs.music.duration
        }
        this.music.isPlay=!this.$refs.music.paused
        this.music.currentTime = this.$refs.music.currentTime
      },
      play(){
        if(this.$refs.music.paused){
          this.$refs.music.play()
        }else{
          this.$refs.music.pause()
        }
        this.music.isPlay=!this.$refs.music.paused
        this.$nextTick(()=>{
          document.getElementById('play').blur()
        })
      },
      changeTime(time){
        this.$refs.music.currentTime = time
      },
      changeVolume(v){
        this.music.volume += v 
        if(this.music.volume>100){
          this.music.volume = 100
        }
        if(this.music.volume<0){
          this.music.volume = 0
        }
        this.$refs.music.volume = this.music.volume/100
      },
      formatTime(time){
        let it = parseInt(time)
        let m = parseInt(it/60)
        let s = parseInt(it%60)
        return (m<10?"0":"")+parseInt(it/60)+":"+(s<10?"0":"")+parseInt(it%60)
      }


  }
});