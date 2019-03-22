tell application "iTerm"
    activate
    set myterm to (make new terminal)
    tell myterm
        launch session "Default Session"
        tell the last session
            write text "cd ~/dev/myapp"
            write text "make foo"
        end tell
        launch session "Default Session"
        tell the last session
            write text "cd ~/dev/myapp"
            write text "make bar"
        end tell
    end tell
end tell