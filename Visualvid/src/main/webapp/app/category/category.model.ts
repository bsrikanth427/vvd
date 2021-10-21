export interface CategoryNode {
  name?: string;
  type?: string;
  id?: string;
  children?: CategoryNode[];
}

export interface Category {
  name: String;
  id?: string;
  nameFormatted?: string;
  subCategories?: SubCategory[];
}

export interface SubCategory {
  categoryId?: String;
  categoryName?: String;
  id?: string;
  name?: string;
}
