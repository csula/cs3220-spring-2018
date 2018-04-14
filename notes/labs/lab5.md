# Lab 5

## Deliverables

* Single txt file containing link to **the pull request** and **CS3 application**

* `admin-events.jsp`
* `AdminEventsServlet.java`
* Deploy to CS3 server
* Refactor events configuration page to use JSP

## Descriptions

In this lab, we continue the implementation of lab 4 to transform our
`out.println` statements to use JSP instead.

I'm assuming most students should have the majority of the lab 4 completed by now
as the due date was the beginning of the class today.

As reminder, events admin page looks like below:

![admin events configuration pages](../imgs/project/admin-events.png)

Your technical refactor goal is to remove the HTML code from the JavaServlet and
passing the data to the correct JSP file. In pseudocode format, JavaServlet logic
should look something like:

```
doGet(req, res) {
    data := dao.getAll()
    req.put("data", data)
    res.dispatch("jsp").forward(req, res)
}
```

While all of data mutation, goes through the same process of parsing request,
update DAO and send redirect.

## Requirements

### Functional

* Application should perform the same as lab 4

### Technical

* All presentation code should go to JSP
* JSP should be hidden under `WEB-INF` folder (not accessible directly)
* No HTML output in Servlet (no `out.println`)
* No Java code in JSP (no computation in JSP)
