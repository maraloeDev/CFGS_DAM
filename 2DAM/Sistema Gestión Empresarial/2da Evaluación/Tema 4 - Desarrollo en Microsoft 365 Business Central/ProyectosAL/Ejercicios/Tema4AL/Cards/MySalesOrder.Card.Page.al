page 50105 "My Sales Order "
{
    PageType = Card;
    ApplicationArea = All;
    UsageCategory = Administration;
    SourceTable = "Sales Header";
    SourceTableView = where("Document Type" = const("Order"));
    //Se indican las categorias a crear
    // PromotedActionCategories = "Inicio, Acciones, Informes,Navegación";

    layout
    {
        area(Content)
        {
            group(General)
            {
                Caption = 'General';

                field("No."; Rec."No.")
                {
                    ApplicationArea = All;
                }

                field("Sell-to Customer No."; Rec."Sell-to Customer No.")
                {
                    ApplicationArea = All;
                }

                field("Sell-to Customer Name"; Rec."Sell-to Customer Name")
                {
                    ApplicationArea = All;
                }

                field("Sell-to Address"; Rec."Sell-to Address")
                {
                    ApplicationArea = All;
                }

            }

            group(Shipping)
            {
                Caption = 'Shipping';

                field("Ship-to Code"; Rec."Ship-to Code")
                {
                    ApplicationArea = All;
                }

                field("Ship-to Name"; Rec."Ship-to Name")
                {
                    ApplicationArea = All;
                }

            }
        }
        area(Factboxes)
        {

            part(SalesLine; "Sales Order Subform")
            {
                ApplicationArea = All;
                SubPageLink = "Document Type" = field("Document Type"), "Document No." = field("No.");

            }
        }

    }

    actions
    {
        area(Processing)
        {
            action(Action1)
            {
                ApplicationArea = All;
                Caption = 'Action 1';

                trigger OnAction();
                begin
                    page.Run(Page::"Customer Card");

                end;
            }
        }
        area(Navigation)
        {
            action(Action2)
            {
                ApplicationArea = All;
                Caption = 'Action 2';
                RunObject = page "Vendor Card";

                trigger OnAction();
                begin

                end;
            }
        }
        area(Creation)
        {
            action(Action3)
            {
                ApplicationArea = All;
                Caption = 'Action 3';
                RunObject = page "Customer Card";

                trigger OnAction();
                begin

                end;
            }
        }
        area(Reporting)
        {
            action(Action4)
            {
                ApplicationArea = All;
                Caption = 'Action 4';
                Promoted = true;
                //PromotedCategory = "Inicio";
                PromotedOnly = true; //Para que solo aparezca en el grupo de informes
                trigger OnAction();
                begin

                end;
            }
        }
    }
}