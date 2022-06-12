package org.devops

//CD发布方法

//saltstack
def SaltDeploy(hosts,func){
  sh " salt \"${hosts}\"${func}"
}
  

//ansilbe
def AnsibleDeploy(hosts,func){
  sh " ansible ${func} ${hosts}"
}
