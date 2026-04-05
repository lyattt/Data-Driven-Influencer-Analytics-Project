# CS2114prj5_127


## Overview
This project analyzes social media influencer performance by processing engagement data from CSV files. It computes and compares engagement metrics across influencers, highlighting how content performance varies based on user interaction.

The program focuses on identifying trends in engagement using both traditional and reach-based metrics, providing insight into how influencers perform across different conditions.

## Key Features
- Parses influencer data from CSV files
- Stores data using a custom singly linked list
- Calculates engagement metrics:
  - Traditional engagement rate = (likes + comments) / followers
  - Reach engagement rate = (likes + comments) / views
- Aggregates engagement rates across Q1 (January–March)
- Sorts influencers:
  - Alphabetically by channel name
  - By engagement rate (highest to lowest)
- Handles missing or undefined values (e.g., zero views)

## Data Model
- **Influencer**: stores username, channel name, country, topic, and monthly stats
- **MonthlyStats**: tracks likes, posts, followers, comments, and views
- **Custom Linked List**: implemented from scratch to manage influencer data

## Algorithms & Concepts Used
- Insertion sort on a custom linked list
- Comparator-based sorting strategies
- Data aggregation across time periods (Q1 averages)
- File parsing and data cleaning from CSV input

## My Contribution
I contributed to the data processing and sorting logic of the system, including:
- Implementing comparator-based sorting for engagement metrics
- Structuring influencer data for efficient analysis
- Supporting the calculation and comparison of engagement rates

## Example Output
The program outputs ranked influencers by engagement:


  


