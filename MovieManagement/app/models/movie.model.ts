export class Movie {
  id: number;
  name: string;
  description: string;
  rating: string;
  length: string;
  img: string;
  cover: string;
  userid: string;
  constructor(name: string, description: string, rating: string,
    length: string, img: string, cover: string) {

    this.name = name;
    this.description = description;
    this.rating = rating;
    this.length = length
    this.img = img;
    this.cover = cover;
  }

}
