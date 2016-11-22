# TOAST TK - Agent Plugin Example

This is an example of a web action adapter plugin.
Plugins are used to extend the agent test execution vocabulary and SUT (System Under Test) driving capabilities.

# How to create a plugin

1. Create a new maven project
2. Add a dependency to both the adapter and the agent api
```xml
	<dependency>
		<groupId>io.toast-tk</groupId>
		<artifactId>toast-tk-adapters-api</artifactId>
		<version>0.1.5-SNAPSHOT</version>
	</dependency>
	<dependency>
		<groupId>io.toast-tk</groupId>
		<artifactId>toast-tk-agent-api</artifactId>
		<version>0.1.5-SNAPSHOT</version>
	</dependency>
```
3. Create a class that extends IAgentPlugin (i.e: my.first.plugin.MyAgentPlugin)
4. Bind your actions adapters (example from PluginExample.java) 
```java
	@Override
	public Collection<? extends Module> getModules() {
		Module module = new AbstractActionAdapterModule() {
			@Override
			protected void configure() {
				bindActionAdapter(WebActionAdapter.class);			
			}
		};
		return Arrays.asList(module);
	}
```
5. Add the plugin service locator to your project META-INF folder
```
	src/main/resources
	 |__ META-INF
	 |____ services
	 |______ io.toast.tk.plugin.IAgentPlugin
```
6. Reference your plugin Class Qualifid name in io.toast.tk.plugin.IAgentPlugin file
```
my.first.plugin.MyAgentPlugin
```
7. Package a standalone version of your plugin:
- Use maven-assembly plugin (the plugin must include it's runtime dependencies)
- assembly.xml example:
```xml
<assembly
	xmlns="http://maven.apache.org/plugins/maven-assembly-plugin/assembly/1.1.2"
	xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	xsi:schemaLocation="http://maven.apache.org/plugins/maven-assembly-plugin/assembly/1.1.2 http://maven.apache.org/xsd/assembly-1.1.2.xsd">
	<id>plugin</id>
	<formats>
		<format>jar</format>
	</formats>
	<includeBaseDirectory>false</includeBaseDirectory>
	<dependencySets>
		<dependencySet>
			<outputDirectory>/</outputDirectory>
			<useProjectArtifact>true</useProjectArtifact>
			<unpack>true</unpack>
			<scope>runtime</scope>
			<excludes>
			</excludes>
		</dependencySet>
	</dependencySets>
</assembly>
```
- Maven assemble plugin example:
```xml
<plugin>
	<groupId>org.apache.maven.plugins</groupId>
	<artifactId>maven-assembly-plugin</artifactId>
	<version>2.5.3</version>
	<executions>
		<execution>
			<goals>
				<goal>attached</goal>
			</goals>
			<phase>package</phase>
			<configuration>
				<finalName>toast-tk-example</finalName>
				<descriptor>src/assembly/bin.xml</descriptor>
			</configuration>
		</execution>
	</executions>
</plugin>
```

8. You're done, the assembled jar can be copied to the agent plugin directory.

# Contribution

Toast TK is a young ![Open Source Love](https://badges.frapsoft.com/os/v3/open-source.svg?v=103) project.  

For contribution rules and guidelines, See [CONTRIBUTING.md](https://github.com/toast-tk/toast-tk-engine/blob/snapshot/CONTRIBUTING.md)

If you'd like to help, [get in touch](https://gitter.im/toast-tk/toast-tk-engine) and let us know how you'd like to help. We love contributors!! 

# Licence
See [Toast-tk Apache License 2.0](https://github.com/toast-tk/toast-tk-engine/blob/snapshot/LICENSE.md)