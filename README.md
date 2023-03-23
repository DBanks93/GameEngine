# Java Game Engine

This is a very WIP game engine. The aim is to create a game engine in Java where people can write scripts to create their own games. 
It won't be complex and until I feel happy about base code and what's implemented

So far all you can do is add a camera to a blank/black scene... but more is to come this is just a teaser
At the moment it's WIP but feel free to check it out so far!!

__I have a test game that shows the basics of the engine and how you can use it (example.testGame.java)__

To create a game with a scene:
1) Create a class with a main Method *(You can either extend Game or just call Game everytime you with to call a function - This may change in furture versions)* with the function Game.init()
2) Then anywhere in your code:
- Game.createScene(sceneName, Size of the game window (As a Vector2D), Bool if the game window should have a full screen cam)
- Game.loadScene(sceneName)
OR
Game.setStartScene(sceneName)

You can also create cameras, however the main camera is the only one that renders currently:
sceneInstance.addMainCamera(Size_of_the_camera_display_Window_in_the_game_window) - should only be used if Bool in createScene is false and you want a custom cam
sceneInstance.addCamera(cameraName, position, cameraWindowSize)

I will generate a javadoc to help, there is currently java doc in my code but as this is very WIP with small edits being added frequetly I will wait until I have made good progress

**Requirements:**
-
- Java 8 (or higher)  {I used Java 19 on my Machine}
- JavaFx
