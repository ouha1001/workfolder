
## Erzeugen eines Docker Image
## Image erhält den Namen mysql_image 
## Muss nur einmal ausgeführt werden

docker build -f Dockerfile -t swtp_image .


## Erzeugen eines Docker Container
## - Im Container werden automatisch SQL-Scripte ausgeführt
## - Es erfolgt ein Netzwerk- und Datei-Mapping
## Ausführen im Projektverzeichnis
## Muss nur einmal ausgeführt werden

== MacOS oder Linux  ==

docker run --name swtpContainer -d -p3306:3306 swtp_image

== Windows  ==

docker run --name swtpContainer -d -p3306:3306 swtp_image


## Nachdem der Container erzeugt wurde
## kann er immer wieder gestartet oder beendet werden

docker start swtpContainer 
docker stop swtpContainer 

## ---------------------------------------
## Nützliche Kommandos

# Löschen eines Images 
# (Alle zugehörigen Container müssen gelöscht werden)
docker image rm <imagename>

# Löschen eines Container
# (Es darf keine laufende Instanz des Containers geben)
docker rm <containername>

# Anzeigen vorhandener Images
docker images

# Anzeigen laufender Container
docker ps

# Anzeigen allerContainer
docker ps -a



