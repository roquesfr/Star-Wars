# Star Wars



1 Introduction :
	
	L’application StarWars est une application web déployée sur un serveur d’application Tomcat servant des pages html au navigateur du client. Les données sont persistées dans une base MySQL.

2 Prérequis :
	
	Un JRE ou JDK version 7 ou plus. On utilise openjdk 11, trouvable ici : 			 		
	https://jdk.java.net/archive/
	Définir la variable d’environnement $JAVA_HOME

	MySQL Server, trouvable ici :
	https://dev.mysql.com/downloads/mysql
	Créer un utilisateur « admin » de mot de passe « admin »
                « mysql -u root
	    GRANT ALL PRIVILEGES ON *.* TO ‘admin’@’localhost’ IDENTIFIED BY ‘admin’ ;
	    \q »
	Créer une nouvelle base de données « star_wars »
	    « mysql -u admin -p
	    CREATE DATABASE star_wars ;
	    \q »

	Apache Tomcat. On utilise la version 8.5, trouvable ici : 			 		 		
	https://tomcat.apache.org/download-80.cgi

	Maven. On utilise la dernière version, trouvable ici :
	https://maven.apache.org/download.cgi
	Ajouter {maven}/bin à la variable d’environnement $PATH.
	

3 Compilation et Déploiement :
	
Cloner le dépôt Git depuis le GitLab LDNR :
	 ‘git clone https://www.campus-numerique.eu/ldnr/gitlab/2022-2-java/equipe-3/star-wars.git’

	Dans le dossier StarWars, exécuter la commande « mvn package »
	Renomer target/StarWars-1.0-SNAPSHOT.war en StarWars.war puis le déplacer dans 	{tomcat}/webapps




4 Lancement :
	
	Sous Linux, lancer {tomcat}/bin/startup.sh
	Sous Windows, {tomcat}/bin/startup.bat
	Dans un navigateur web, accéder à l’application à l’adresse http://localhost:8080/StarWars/
