Indian Institute of Technology, Kharagpur Department of Computer Science and Engineering Software Engineering (CS 29006/CS29202), Spring 2022
Assignment 2 – C++ Programming
1. Zero marks for a submission if it does not pass the plagiarism test. 2. Break-up of Credits will be as follows:
(a) Percentage of features implemented: 70%
(b) Aesthetics: 10%
(c) Whether reasonably able to answer questions: 20%
Total marks: 70
Openstreetmap (www.openstreetmap.org) is a free and open resource which provides high quality map data for all areas in the world. They provide the data in the OSM format which can be downloaded from their website. OSM is an xml-based format, which has various elements and the attributes for those elements. The purpose of this assignment is to develop a software which reads data about various artifacts on the map, and provide a text searchable interface to the map.
An OSM file of the Kharagpur area is given to you for reference.
Two particular elements of the OSM format, are of interest.
• “node”: This represents a particular place on the map, e.g. a shop, building, etc. It has an
id, latitude, and longitude. Additionally, some node elements have a “name” attribute
which describes the place.
• “way”: This represents a path or a line through the map, and is denoted by a sequence of
node elements. This element also has an id, and optionally a name describing the
Use case 1:
Write a C++ program which parses a given OSM file and extracts the node and way elements from the file along with their attributes. It should print the total number nodes and ways discovered in the given file. It allow a user to search for a particular element by matching input string with substring of the name. You can use a xml parsing library to parse the file.
[30 marks]
Use case 2:
Given an input OSM write a C++ program which can find the k-closest nodes to a given node using the crow fly distance. Here k is a user input. You can use the latitude, longitude information of
 nodes to calculate the distance.
Given an input OSM file, write a C++ program which calculates the shortest path between two node elements, through the way elements. The distance on a way is the sum of distances between consecutive node elements in the way. You can follow the following steps:
1. Create an incidence data structure which stores whether ith way contains jth node.
2. Create a graph between the nodes and calculate the shortest “1-hop” distance between
the nodes.
3. Run a shortest path algorithm on this graph.
[30 marks]
