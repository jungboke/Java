# Java
maven project1:  
1.maven project의 구성은 크게 src dir안에 main dir, 그안에 일반java file이 들어가있는 java dir,  
java file이 구동하기 위해 필요한 설정 file들이 들어가있는 resources file로 구성됨.  
2.가장 큰 범주인 group(spring framework)안에 여러 spring project들이 들어가있는 구조이며,  
그러한 project들은 library를 필요로 함. 그러한 library들을 import할수 있도록 해당 project의  
pom.xml file안에 아래코드를 추가하여 여러 library(spring-context,spring-aop...)등을 가져올수 있음.

```
<dependencies>
		<dependency>
			<groupId>org.springframework</groupId>
			<artifactId>spring-context</artifactId>
			<version>4.1.0.RELEASE</version>
		</dependency>

	</dependencies>


	<build>
		<plugins>
			<plugin>
				<artifactId>maven-compiler-plugin</artifactId>
				<version>3.1</version>
				<configuration>
					<source>1.8</source>
					<target>1.8</target>
					<encoding>utf-8</encoding>
				</configuration>
			</plugin>
		</plugins>
	</build>
```
