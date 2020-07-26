export class Theater {
  id: number;
  name: string;
  address: string;
  citi: string;
  rating: number;
  img: string;
  userid: string;
  constructor(name: string, address: string, citi: string, rating: number,
     img: string) {

    this.name = name;
    this.address = address;
    this.rating = rating;
    this.citi = citi;
    this.img = img;
  }

}
