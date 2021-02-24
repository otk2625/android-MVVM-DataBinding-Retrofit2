## HTML 코드

![blog](https://postfiles.pstatic.net/MjAyMDA5MjJfMjg3/MDAxNjAwNzQ2NjkwMjAw.PYH9ZRqMBPK8PbHrbkMGI2AvX2eg4893V_IvCLy5ossg.6brkyCFqigBeensFHeYcT0skpYmoaRRZxNe4x2TLo7Mg.PNG.getinthere/Screenshot_2.png?type=w773)

```html
<!DOCTYPE html>
<html lang="en">
  <head>
    <title>Bootstrap Example</title>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1" />
    <link
      rel="stylesheet"
      href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
    />
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
    <style>
      .card-grid {
        display: grid;
        grid-template-columns: auto auto auto;
        justify-content: space-around;
        grid-row-gap: 30px;
      }
    </style>
  </head>

  <body>
    <nav class="navbar navbar-expand-md bg-dark navbar-dark">
      <a class="navbar-brand" href="#">MOVIE</a>
      <button
        class="navbar-toggler"
        type="button"
        data-toggle="collapse"
        data-target="#collapsibleNavbar"
      >
        <span class="navbar-toggler-icon"></span>
      </button>
      <div class="collapse navbar-collapse" id="collapsibleNavbar">
        <ul class="navbar-nav">
          <li class="nav-item">
            <a class="nav-link" href="#">인기영화</a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="#">추천영화</a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="#">최신영화</a>
          </li>
        </ul>
      </div>
    </nav>
    <br />

    <div class="container">
      <div class="card-grid">
        <!-- 카드시작 -->

        <!-- 카드끝 -->
      </div>
    </div>

    <script>
      let url = "http://localhost:8000/api/movie";

      fetch(url)
        .then(function (r) {
          return r.json();
        })
        .then(function (r) {
          let movies = r;
          addDiv(movies);
        });

      function addDiv(movies) {
        console.log(movies);
        let cardGrid = document.querySelector(".card-grid");
        for (movie of movies) {
          console.log(movie);
          let title = movie.title;
          let rating = movie.rating;
          let medium_cover_image = movie.medium_cover_image;

          let newDiv = document.createElement("div");
          newDiv.id = "card-" + movie.id;
          newDiv.className = "card";
          newDiv.style = "width:300px";
          // 백틱을 사용하면 템플릿 리터럴을 사용할 수 있다. ex) ${}
          let cardImg = `<img class='card-img-top' src='${medium_cover_image}' alt='Card image'><div class='card-body'><h4 class='card-title'>${title}</h4><p class='card-text'>평점 ${rating}</p><button class='btn btn-danger' onclick="deleteById(${movie.id})">영화 삭제</button></div>`;
          newDiv.innerHTML = cardImg;

          cardGrid.append(newDiv);
        }
      }

      function deleteById(movieId) {
        // DB내용 삭제 없이 제거하기
        let card = document.querySelector("#card-" + movieId);
        card.parentElement.removeChild(card);

        // 실제 DB내용 지우고 완료되면 제거하기
        // fetch("http://localhost:8000/api/movie/" + movieId, {
        //   method: "delete",
        // })
        //   .then(function (res) {
        //     return res.text();
        //   })
        //   .then(function (res) {
        //     if (res === "ok") {
        //       alert("삭제성공");
        //       let card = document.querySelector("#card-" + movieId);
        //       card.parentElement.removeChild(card);
        //     } else {
        //       alert("삭제실패");
        //     }
        //   });
      }
    </script>
  </body>
</html>

```