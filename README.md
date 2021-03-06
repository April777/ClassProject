# Manage Class Notes

1. What is the proposed name for your Web application?
    - manage-class-notes
2. Who is the target audience for your Web application?
    - Students at University of Pittsburgh, for the time being.
3. What problem is it intended to solve for the target audience?
    - Some foreign students may have difficulties in understanding what their professors teach during the class, so they may perform bad in the final exam. So I will provide a platform for them to share their class notes in order to have a better understanding about the class materials.
    - Besides, I will provide discussion board for students. So they can learn from each other, and at the same time, students who have the same class can have a better connection.
4. How will it meet the minimum project requirements?
    - My site will support CRUD (create, read, update and delete) funcions for students. And all school information and class information will be created by the administrator.
5. Why is your proposed Web application unique or creative beyond simply meeting the minimum requirements?
    - Students can see the note list of a course, and can read the course list in a school.
    

## Build status

[![Build Status](https://travis-ci.org/infsci2560sp17/full-stack-web-April777.svg?branch=master)](https://travis-ci.org/infsci2560sp17/full-stack-web-April777)

## Changelog

[Changelog](CHANGELOG.md)

## Web Site

[Manage Class Notes](https://share-class-notes.herokuapp.com/)

## Key Features

* Key Feature 1
Users can see all notes uploaded before.
* Key Feature 2
Users can add new notes.

## Project Details

### Landing Page

TODO : please provide a description of your landing page inluding a screen shot ![](https://.../image.JPG)

### User Input Form

TODO : please provide a description of at least 1 user input form including a screen shot ![](https://.../image.jpg)

## API

TODO : please provide a description of at least 1 API including a sample of request data and response data in both XML and JSON format.

### API Method 1

    POST photos/:id/tags

#### Parameters

- **id** _(required)_ — The Photo ID to add tags for.
- **tags** _(required)_ — Comma separated tags.

#### Response

A JSON or XMLobject containing the PhotoID and list of tags accepted.

#### Errors

All known errors cause the resource to return HTTP error code header together with a JSON array containing at least 'status' and 'error' keys describing the source of error.

- **404 Not Found** — The photo was not found.

#### Example

##### Request

    POST /v1/photos/123456/tags

##### Body

    tags=cute,puppy


##### JSON Response

```json
{
    "photoId": 123456,
    "tags": ["cute", "puppy"]
}
```

##### XML Response

```xml
<?xml version="1.0" encoding="UTF-8"?>
<PhotoTags>
    <photoId>123456</PhotoId>
        <tags>
            <tag>cute</tag>
            <tag>puppy</tag>
        </tags>
</PhotoTags>
```

## Technologies Used

TODO : List all technologies used in your project

- [Spring Boot](https://projects.spring.io/spring-boot/) - Takes an opinionated view of building production-ready Spring applications.
- [Thymleaf](http://www.thymeleaf.org/) - Thymeleaf is a modern server-side Java template engine for both web and standalone environments.
- [Maven](https://maven.apache.org/) - Apache Maven is a software project management and comprehension tool.
