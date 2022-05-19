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
        stage('getcode') { //阶段名称
            steps { //步骤
                timeout(time: 3, unit:'MINUTES'){ //设置超时时间
				   script{ //运行代码
				        println('拉去代码')
				        
				        println("${test}")
						//使用用户输入确认信息
				        input id: 'test', message: '请确认项目名称', ok: '是的，请继续吧！', parameters: [choice(choices: ['a', 'b'], name: 'test')], submitter: 'admin'
					}	
				}
            }
        }
		
		stage('bulid') {//步骤2
            steps { 
                timeout(time: 2, unit:'MINUTES'){
				   script{
				        println('构建')
				        //引用mvn
				        mvnHome=tool "m3"
				        println(mvnHome)
				        
				        sh "${mvnHome}/bin/mvn --version"
				        
					}
				}
            }
        }
		
		stage('codescan') {//步骤3
            steps { 
                timeout(time: 3, unit:'MINUTES'){
				   script{
				        println('代码扫描')
						tools.PrintMes('this my share library')
					}
				}
            }
        }
		
		stage('test') {//步骤4
            steps { 
                timeout(time: 4, unit:'MINUTES'){
				   script{
				        println('代码测试')
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
		  }
		}
		failure {
		  script{
		    currentBuild.description = "\n 构建失败！"
		  }
		}
		aborted {
		  script{
		    currentBuild.description = "\n 用户取消！"
		  }
		}		
    }
	
	
}
