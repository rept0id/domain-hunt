# domainHunt ![java-11](https://img.shields.io/badge/java-11-f39f37)

![screenshot](https://github.com/rept0id/domainHunt/blob/main/Screenshot_2023-10-16_05_36_09.png)

Explore available domain names inspired by given dictionary

Our default dictionary, brimming with art painting names, is a treasure trove of possibilities. 🎨

Discover gems like streetinvenice.com. Should I make this domain mine first ? 🤔😃

Dictionary path : ./src/main/resources/dictionary

## Prepare

You may wish to install docker. For debian-based :
```
sudo apt-get install docker docker-compose
```

Then, simply verify your Java version :
```
java --version
```

It must be 17, at the very least, for this project.

In the event it's not 17, you might consider employing SDKMAN for effortlessly toggling between Java versions!

Refer to my note here for guidance on how to switch to Java 17 -> [note](https://github.com/rept0id/notes/blob/main/Shared/sdkman-java17.md).

## Build and Run

To build : 
```
sudo make build
```

To build and run :
```
sudo make build-run
```

To simply run :
```
sudo make run
```

To stop :
```
sudo make stop
```

This project uses docker-compose, so do not forget to run 'sudo make stop', as above, once you are done!.

Example of running :
```
> sudo make run 
```

```
sudo docker-compose down;
Removing network domainhunt_default
WARNING: Network domainhunt_default not found.
sudo docker-compose up;
Creating network "domainhunt_default" with the default driver
Creating domainhunt_app_1 ... done
Attaching to domainhunt_app_1
app_1  | Hello World!
app_1  | thegirlwithapearlearring.com : domain state : unregistered
app_1  | portraitofayoungvenetianwoman.com : domain state : unregistered
app_1  | portraitofdaniel-henrykahnweiler.com : domain state : unregistered
app_1  | thebattlebetweenlentandcarnival.com : domain state : unregistered
app_1  | skullwithburningcigarette.com : domain state : unregistered
app_1  | self-portraitwithmonkeys.com : domain state : unregistered
app_1  | selfportraitwithbandagedearandpipe.com : domain state : unregistered
app_1  | greatsceneofagony.com : domain state : unregistered
app_1  | seascapeatsaintes-maries.com : domain state : unregistered
app_1  | viewofmurnauwithtrainandcastel.com : domain state : unregistered
app_1  | thegrandcanalandthechurchofthesalute.com : domain state : unregistered
app_1  | sabartes.com : domain state : unregistered
app_1  | sunsetatsea.com : domain state : unregistered
```
