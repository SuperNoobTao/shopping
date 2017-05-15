/**
 * Created by wqj on 2017/3/23.
 */
window.onload=function(){//等页面加载完毕的时候触发代码
    var sliderObj={
        flashNode:document.getElementById('flash'),
        autoDo:null,
        posFun:function(nodes,attr,cont){//nodes表示节点集合;attr表示nodes[i]某个属性；cont表示条件；//函数作用：得到条件对应的位置
            for(var i=0;i<nodes.length;i++){
                if(nodes[i][attr]==cont){//列如spanNodes[i].className//spanNodes[i]["className"]
                    return i;
                }
            }
        },
        mouseEnterFun:function(e){//e鼠标事件对象;
            var _this=this;
            var event=window.event || e;
            var target=event.srcElement || event.target;//节点
            if(target.nodeName.toLowerCase()=="span" && target.parentNode.nodeName.toLowerCase()=="div"){//进入的就是span按钮
                if(target.className=='current'){
                    return;
                }

                var oldPos=_this.posFun(_this.spanNodes,"className","current");//得到之前位置
                target.className="current";//移到当前节点加样式
                _this.spanNodes[oldPos]['className']='';//等价_this.spanNodes[oldPos].className='';

                var curPos=_this.posFun(_this.spanNodes,"className","current");//当前位置

                //console.log(oldPos,curPos);

                _this.liNodes[oldPos].style.display="none";
                _this.liNodes[curPos].style.display="";
            }
        },
        init:function(){//初始化
            var _this=this;
            _this.liNodes=_this.flashNode.getElementsByTagName('li');//给json对象sliderObj新添属性liNodes
            _this.spanNodes=_this.flashNode.getElementsByTagName('div')[0].getElementsByTagName('span');////给json对象sliderObj新添属性spanNodes

            _this.aNods=_this.flashNode.getElementsByTagName('a');

            _this.leftNode=_this.aNods[0];
            _this.rightNode=_this.aNods[_this.aNods.length-1];

            _this.flashNode.onmouseover=function(e){
                window.clearInterval(_this.autoDo);//清除动画
                //this;//指向事件触发的对象
                _this.mouseEnterFun(e);
            }

            _this.flashNode.onmouseout=function(e){
                _this.autoDo=window.setInterval(_this.rightNode.onclick,3000);//自动切换
            }

            _this.leftNode.onclick=function(){
                var oldPos=_this.posFun(_this.spanNodes,"className","current");
                var lastPos=_this.spanNodes.length-1;
                var curPos=oldPos==0?lastPos:oldPos-1;

                _this.spanNodes[curPos].className="current";//移到当前节点加样式
                _this.spanNodes[oldPos]['className']='';//等价_this.spanNodes[oldPos].
                _this.liNodes[oldPos].style.display="none";
                _this.liNodes[curPos].style.display="";
            };

            _this.rightNode.onclick=function(){
                var oldPos=_this.posFun(_this.spanNodes,"className","current");
                var lastPos=_this.spanNodes.length-1;
                var curPos=oldPos==lastPos?0:oldPos+1;

                _this.spanNodes[curPos].className="current";//移到当前节点加样式
                _this.spanNodes[oldPos]['className']='';//等价_this.spanNodes[oldPos].
                _this.liNodes[oldPos].style.display="none";
                _this.liNodes[curPos].style.display="";
            };//子函数可以得到父函数的变量；父函数不能得到子函数的变量

            //console.log(_this.rightNode.onclick);
            _this.autoDo=window.setInterval(_this.rightNode.onclick,3000);//自动切换
        }
    };

    sliderObj.init();
};

//蒙层操作
$('#shade span,#loginbtn').click(function(){
    $('#shade').slideToggle();
});
