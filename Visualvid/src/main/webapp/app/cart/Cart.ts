export class Cart {
  id: string;
  userId: string;
  mediaId: string;
  mediaName: string;
  constructor(id: string, userId: string, mediaId: string, mediaName: string) {
    this.id = id;
    this.userId = userId;
    this.mediaId = mediaId;
    this.mediaName = mediaName;
  }
}
