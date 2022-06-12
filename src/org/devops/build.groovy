package org.devops

//构建类型

def Build(BuildType,BuildShell){
    def BuildTools = ['mvn':'MAVEN','ant':'ANT','gradle':'GRADLE']
    println("当前选中构建类型:" ${BuildType})
    BuildHome = tool BuildTools[BuildType]

    sh "${BuildHome}/bin/${BuildType} ${BuildShell} "
}
