# weather-module
weather module for your polybar config

# Set Up
* Download jar (if not building from source)
* Get yourself a free weather API token [https://openweathermap.org/](link)
* Find your lon and lat

# Requirements (building from source)
* JSoup
* GSon
* ~~Jauntium Java (free is short-term)~~

# Example polybar config

```
[module/feel]
type = custom/script

interval = 1
exec = sh ~/.config/polybar/scripts/weather.sh <lon> <lat> <api_key> feel
format = <label>
format-padding = 0
format-prefix-font = 15
format-prefix = "   "
format-foreground = ${colors.blue-gray}
format-prefix-foreground = ${colors.aqua}
#        


[module/temp]
type = custom/script

interval = 1
exec = sh ~/.config/polybar/scripts/weather.sh <lon> <lat> <api_key> temp
format-prefix-font = 15
format = <label>
format-padding = 1
format-foreground = ${colors.blue-gray}


[module/humid]
type = custom/script

interval = 1
exec = sh ~/.config/polybar/scripts/weather.sh <lon> <lat> <api_key> humid
format-prefix-font = 15
format = "<label>%"
format-padding = 0
format-prefix = "  💧 "
format-foreground = ${colors.blue-gray}
format-prefix-foreground = ${colors.indigo}


[module/speed]
type = custom/script

interval = 1
exec = sh ~/.config/polybar/scripts/weather.sh <lon> <lat> <api_key> speed
format = <label>
format-padding = 0
format-prefix-font = 15
format-prefix = "   "
format-foreground = ${colors.blue-gray}
format-prefix-foreground = ${colors.indigo}


[module/weather]
type = custom/script

interval = 1
exec = sh ~/.config/polybar/scripts/weather.sh <lon> <lat> <api_key> status
format-font = 15
format = "<label>"
format-padding = 0
format-foreground = ${colors.aqua}
```
