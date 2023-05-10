# ebay-price-alerts
Continually checks &amp; alerts for eBay price drops that you set. GUI is included to make usage simple. 

## Table of Contents
- [Screenshots](https://github.com/stevenha75/ebay-price-alerts#screenshots)
- [Installation & Usage](https://github.com/stevenha75/ebay-price-alerts#installation--usage)
  - [Dependencies](https://github.com/stevenha75/ebay-price-alerts#dependencies)
  - [Installation](https://github.com/stevenha75/ebay-price-alerts#installation)
  - [Using the program](https://github.com/stevenha75/ebay-price-alerts#using-the-program)

## Task List
- [ ] Add desktop notifications & toggles for notifications in settings
- [x] Refactor gui class
- [ ] Add error catching
  - [x] Catch invalid webhook urls
  - [ ] Catch invalid refresh time
- [ ] Add a way to import a list of items
- [ ] Unit testing

## Screenshots
![image](https://user-images.githubusercontent.com/109867418/231586366-3806e793-cba9-442b-84d1-92c8f564459f.png)

# Installation & Usage
## Dependencies
- [Java](https://www.oracle.com/java/technologies/downloads/)
- All other dependencies are already included via the maven wrapper

## Installation
First, download the program onto your computer
```shell
git clone https://github.com/stevenha75/ebay-price-alerts.git
cd ebay-price-alerts/target
```
Then, run the program
```shell
java -jar ebay-price-alerts-1.0-SNAPSHOT.jar 
```
## Using the program
The program is pretty self explanatory. The refresh button checks the price and sends notifications if the price is less than or equal to the limit set when importing the item. This function only works if the settings were configured w/ a discord webhook b/c this program utilizes discord to handle the notifications. To make a webhook, I reccommend creating your own personal discord server and following these [instructions](https://support.discord.com/hc/en-us/articles/228383668-Intro-to-Webhooks). Once ready, click settings on the program and paste in the webhook link. 
