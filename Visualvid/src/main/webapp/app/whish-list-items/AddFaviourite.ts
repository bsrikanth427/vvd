export class AddFaviourite {
  id: string;
  mediaId: string;
  slideName: string;
  userId: string;
  email: string;

  constructor(id: string, mediaId: string, slideName: string, userId: string, email: string) {
    this.id = id;
    this.mediaId = mediaId;
    this.slideName = slideName;
    this.userId = userId;
    this.email = email;
  }
}
