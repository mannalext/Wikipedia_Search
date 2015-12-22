# Wikipedia_Search
a repo for a "bacon number" game using wikipedia articles


THIS PROJECT IS UNDER ACTIVE DEVELOPMENT


12/22/15
Made the original commits, adding JARs and basic logic to make calls against the API.

Right now a call to return the first 500 links on the “Mars” article is made. The API return value gets stored in “rawResultAsString”. The plan is to parse this, checking for the existence of a continue, and storing the 500 links. If a continue was found, repeat recursively until one is not found, always storing the 500 additional links.

After that, I will have all the links from the original article. That same logic will need to be called on all links from that article, recursively, until the second article name is found among the links. Then, return the number of links between articles A and B.





TODO: 
1. Parse the results of an API call. 
	- Create the infrastructure to run as many continues as necessary while 		adding links to the result		
	- Store links from each call to continue

2. Once you have all the links from article A, test how long it would take to run the same logic (make a call, store links from the page) for every link found on article A. If the time trivial, this project can be done without recursion. Otherwise, develop the recursive / multithreaded algorithm. 

