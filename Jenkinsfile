#!groovy
//应用共享库
@Library('jenkinslib')_

def tools = new org.devops.tools()

pipeline {
    agent any
	
    options {
	   timestamps () //记录日志时间
	   skipDefaultCheckout()
	   disableConcurrentBuilds() //禁止并行
	   timeout(time: 1, unit: 'HOURS')  //设置流水线运行的超时时为1小时
	   
	}
		
   stages {//pipeline 
	   //下载代码
        stage('getcode') { 
            steps { //步骤
                timeout(time: 3, unit:'MINUTES'){ //设置超时时间
				   script{ //运行代码
				        println('拉取代码')
				        tools.PrintMes('拉取代码','red') 
				        println("${test}")
						//使用用户输入确认信息
				        input id: 'test', message: '请确认项目名称', ok: '是的，请继续吧！', parameters: [choice(choices: ['a', 'b'], name: 'test')], submitter: 'admin'
					}	
				}
            }
        }
	 //打包构建	
	stage('bulid') {
            steps { 
                timeout(time: 2, unit:'MINUTES'){
				   script{
				        println('应用打包')
					tools.PrintMes('应用打包','red')
				        //引用mvn
				        mvnHome=tool "m3"
				        println(mvnHome)
				        
				        sh "${mvnHome}/bin/mvn --version"
				        
					}
				}
            }
        }
        //代码扫描
	stage('codescan') {//步骤3
            steps { 
                timeout(time: 3, unit:'MINUTES'){
				   script{
				        println('代码扫描')
						tools.PrintMes('代码扫描','red')
					}
				}
            }
        }
	//测试	
	stage('test') {//步骤4
            steps { 
                timeout(time: 4, unit:'MINUTES'){
				   script{
				        println('代码测试')
					   tools.PrintMes('代码测试','red')
					}
				}
            }
        }
    }
	//构建后的操作
	post { 
        always {
		  script{
		    println("always")
		  }
		}
		
		success {
		  script{
		    currentBuild.description = "\n 构建成功！"
			tools.PrintMes('构建成功！','green')  
		  }
		}
		failure {
		  script{
		    currentBuild.description = "\n 构建失败！"
			  tools.PrintMes('构建失败！','green') 
		  }
		}
		aborted {
		  script{
		    currentBuild.description = "\n 用户取消！"
			  tools.PrintMes('用户取消！','green') 
		  }
		}		
    }
	
	
}
