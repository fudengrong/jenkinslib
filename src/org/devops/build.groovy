package org.devops

//构建类型

def Build(BuildType,BuildShell){
    def BuildTools = ['mvn':'MAVEN','ant':'ANT','gradle':'GRADLE']
    println("当前选中构建类型: ${BuildType}")
    BuildHome = tool BuildTools[BuildType]
    
    if ("${BuildType}"== "node"){
        sh """
           export npmHome=/usr/share/nginx/html/node-v16.15.1-linux-x64
           export PATH=\$PATH:\$npmHome/bin
           node -v
           """
    } else {
    sh "${BuildHome}/bin/${BuildType} ${BuildShell} "
        }
}
